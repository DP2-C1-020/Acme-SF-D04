
package acme.entities.notices;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Notice extends AbstractEntity {

	// Serialisation identifier ----------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes ------------------------------------------------------

	@Temporal(TemporalType.TIMESTAMP)
	@PastOrPresent
	@NotNull
	private Date				instantiationMoment;

	@NotBlank
	@Length(max = 75)
	private String				title;

	@NotBlank
	@Length(max = 75)
	private String				author;

	@NotBlank
	@Length(max = 100)
	private String				message;

	@Email
	@Length(min = 6, max = 254)
	private String				email;

	@URL
	@Length(min = 7, max = 255)
	private String				link;

}
