package com.example.addressbookapp.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Data // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
	
	@NotEmpty(message = "Name is required")
	@Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces")
    private String name;
	
    private String address;
    private String phone;
}
