
package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Advertisement extends DomainEntity {

	// Serialization identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes --------------------------------------------------------------

	@NotBlank
	private String				title;

	@NotBlank
	@URL
	private String				picture;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				creationDate;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				displayedUntil;

	@NotBlank
	private String				textPiece;

	@NotNull
	private Double				smallVolumeDiscount;

	@NotNull
	private Double				averageVolumeDiscount;

	@NotNull
	private Double				largeVolumeDiscount;

	@NotNull
	@Min(2)
	@Max(3)
	private Integer				smallInterval;

	@NotNull
	@Min(4)
	@Max(5)
	private Integer				averageInterval;

	@NotNull
	@Min(6)
	private Integer				largeInterval;

}
