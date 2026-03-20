package designPatterns.Creational.Builder;

public class Address {
    private final String houseNumber;
    private final String line1;
    private final String city;
    private final String postalCode;

    private Address(Builder builder) {
//        String formattedAddress = String.format("%s, %s\nPostal Code:%s,\n%s", builder.houseNumber, builder.line1, builder.postalCode, builder.city);
        this.houseNumber = builder.houseNumber;
        this.line1 = builder.line1;
        this.postalCode = builder.postalCode;
        this.city = builder.city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber='" + houseNumber + '\'' +
                ", line1='" + line1 + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getLine1() {
        return line1;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public static class Builder {
        private String houseNumber;
        private String line1;
        private String city;
        private String postalCode;

        public Builder withHouseNumber(String hNo) {
            this.houseNumber = hNo;
            return this;
        }

        public Builder withLine1(String line1) {
            this.line1 = line1;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Address build() {
            //Put Validations withIllegalStateExcel throw
            return new Address(this);
        }
    }

}
