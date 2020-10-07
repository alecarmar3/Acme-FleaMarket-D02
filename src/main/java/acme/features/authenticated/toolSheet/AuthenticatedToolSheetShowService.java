
package acme.features.authenticated.toolSheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ToolSheet;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedToolSheetShowService implements AbstractShowService<Authenticated, ToolSheet> {

	@Autowired
	private AuthenticatedToolSheetRepository repository;


	@Override
	public boolean authorise(final Request<ToolSheet> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<ToolSheet> request, final ToolSheet entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "providerName", "homePage", "stars");
	}

	@Override
	public ToolSheet findOne(final Request<ToolSheet> request) {
		assert request != null;

		ToolSheet result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

}
