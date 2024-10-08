package org.console.customer;

public class CustomerRecord {
    private final Integer customerRef;
    private final String customerName;
    private final String addressLine1;
    private final String addressLine2;
    private final String town;
    private final String county;
    private final String country;
    private final String postcode;

    public CustomerRecord(CustomerRecordBuilder builder)
    {
        customerRef = builder.customerRef;
        customerName = builder.customerName;
        addressLine1 = builder.addressLine1;
        addressLine2 = builder.addressLine2;
        town = builder.town;
        county = builder.county;
        country = builder.country;
        postcode = builder.postcode;
    }

    public static CustomerRecordBuilder builder() {
        return new CustomerRecordBuilder();
    }

    public Integer getCustomerRef() { return customerRef; }
    public String getCustomerName() { return customerName; }
    public String getAddressLine1() { return addressLine1; }
    public String getAddressLine2() { return addressLine2; }
    public String getTown() { return town; }
    public String getCounty() { return county; }
    public String getCountry() { return country; }
    public String getPostCode() { return postcode; }

    public String toJsonString() {
        return "{\"customerRef\": " + customerRef + "," +
                "\"customerName\": \"" + customerName + "\"," +
                "\"addressLine1\": \"" + addressLine1 + "\"," +
                "\"addressLine2\": \"" + addressLine2 + "\"," +
                "\"town\": \"" + town + "\"," +
                "\"county\": \"" + county + "\"," +
                "\"country\": \"" + country + "\"," +
                "\"postcode\": \"" + postcode + "\"}";
    }
}
