
package acme.entities.invoices;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import acme.client.data.datatypes.Money;
import acme.entities.sponsorships.Sponsorship;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "sponsorship_id, tax, draftMode"), //
	@Index(columnList = "sponsorship_id, draftMode, quantity_currency"), //
	@Index(columnList = "sponsorship_id, dueDate"), //
	@Index(columnList = "sponsorship_id, draftMode, dueDate")
})
public class Invoice extends AbstractEntity {

	// Serialisation identifier ----------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes ------------------------------------------------------

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "IN-[0-9]{4}-[0-9]{4}", message = "{validation.invoice.code}")
	private String				code;

	@NotNull
	@PastOrPresent
	@Temporal(TemporalType.TIMESTAMP)
	private Date				registrationTime;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				dueDate;

	@NotNull
	@Valid
	private Money				quantity;

	@Digits(integer = 3, fraction = 2)
	@Min(0)
	@Max(100)
	private double				tax;

	@URL
	@Length(min = 7, max = 255)
	private String				link;

	private boolean				draftMode;

	// Derived attributes -----------------------------------------------


	@Transient
	public Money getTotalAmount() {

		Money totalAmount = new Money();

		double amount = this.quantity.getAmount() * (1 + this.tax / 100);
		double roundedAmount = Math.round(amount * 100.0) / 100.0;
		totalAmount.setAmount(roundedAmount);
		totalAmount.setCurrency(this.quantity.getCurrency());
		return totalAmount;
	}

	// Relationships ----------------------------------------------------


	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Sponsorship sponsorship;
}
