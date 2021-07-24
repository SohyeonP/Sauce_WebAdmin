package co.kr.circus.sauceweb.shop;

public class Shop {

    private Long store_id;
    private String biz_storename;
    private String phone;
    private String biz_bossname;
    private String biz_address;
    private String biz_number;

    public Long getStore_id() {
        return store_id;
    }

    public void setStore_id(Long store_id) {
        this.store_id = store_id;
    }

    public String getBiz_storename() {
        return biz_storename;
    }

    public void setBiz_storename(String biz_storename) {
        this.biz_storename = biz_storename;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBiz_bossname() {
        return biz_bossname;
    }

    public void setBiz_bossname(String biz_bossname) {
        this.biz_bossname = biz_bossname;
    }

    public String getBiz_address() {
        return biz_address;
    }

    public void setBiz_address(String biz_address) {
        this.biz_address = biz_address;
    }

    public String getBiz_number() {
        return biz_number;
    }

    public void setBiz_number(String biz_number) {
        this.biz_number = biz_number;
    }
}
