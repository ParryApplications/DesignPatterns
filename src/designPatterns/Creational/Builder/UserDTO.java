package designPatterns.Creational.Builder;

import java.time.LocalDate;
import java.time.Period;

/*
If Immutability and too many fields are there -> Use Builder
 */
public class UserDTO {
    private final String name;
    private final int age;
    private final Address address;

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    private UserDTO(Builder builder) {
        this.name = builder.name;
        Period between = Period.between(builder.birthdate, LocalDate.now());
        this.age = between.getYears();
        this.address = builder.address;
    }

    public static class Builder {
        private String name;
        private LocalDate birthdate;
        private Address address;

        public Builder withName(String name) {
            this.name = name;
            return this;//Method Chaining
        }

        public Builder withBirthdate(LocalDate dob) {
            this.birthdate = dob;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public UserDTO build() {
            //Put Validations withIllegalStateExcel throw
            return new UserDTO(this);
        }
    }
}
