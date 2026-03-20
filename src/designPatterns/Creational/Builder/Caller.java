package designPatterns.Creational.Builder;

import java.time.LocalDate;

public class Caller {
    public static void main(String[] args) {
        Address parasUserAddress = new Address.Builder()
                .withHouseNumber("C-4")
                .withLine1("Miranda House")
                .withPostalCode("110007")
                .withCity("Delhi")
                .build();

        UserDTO parasUser = new UserDTO.Builder()
                .withName("Paras")
                .withBirthdate(LocalDate.of(2000, 4, 10))
                .withAddress(parasUserAddress)
                .build();

        System.out.println(parasUser);
    }
}
