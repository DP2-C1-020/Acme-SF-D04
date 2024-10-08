
package acme.roles;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sponsor extends AbstractRole {

	// Serialisation identifier ----------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes ------------------------------------------------------

	@NotBlank
	@Length(max = 75)
	private String				name;

	@NotBlank
	@Length(max = 100)
	private String				benefits;

	@URL
	@Length(min = 7, max = 255)
	private String				webPage;

	@Email
	@Length(min = 6, max = 254)
	private String				emailContact;

}
