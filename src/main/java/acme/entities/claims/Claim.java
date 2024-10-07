
package acme.entities.claims;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Claim extends AbstractEntity {

	// Serialisation identifier ----------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes ------------------------------------------------------

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "C-[0-9]{4}", message = "{validation.claim.code}")
	private String				code;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@PastOrPresent
	private Date				instantiationMoment;

	@NotBlank
	@Length(max = 75)
	private String				heading;

	@NotBlank
	@Length(max = 100)
	private String				description;

	@NotBlank
	@Length(max = 100)
	private String				department;

	@Email
	@Length(min = 6, max = 254)
	private String				email;

	@URL
	@Length(min = 7, max = 255)
	private String				link;

	private boolean				draftMode;

}
