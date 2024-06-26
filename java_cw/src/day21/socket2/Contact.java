package day21.socket2;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact implements Serializable {
	
	private static final long serialVersionUID = 123L;
	
	private String name;
	private String number;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(number, other.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
	
	@Override
	public String toString() {
		return "[" + name + " : " + number + "]" ;
	}

	public void update(Contact newContact) {
		this.name = newContact.name;
		this.number = newContact.number;
	}
	
}