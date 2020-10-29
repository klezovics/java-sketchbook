package com.klezovich.demo.datafactory;

public class InvoiceItem {

    private Long id;

    public InvoiceItem(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    private String description;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private InvoiceItem(Builder builder) {
        setId(builder.id);
        setDescription(builder.description);
    }

    public static final class Builder {

        private Long id;
        private String description;

        public Builder() {}

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public InvoiceItem build() {
            return new InvoiceItem(this);
        }
    }
}
