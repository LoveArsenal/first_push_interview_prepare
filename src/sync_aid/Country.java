package sync_aid;

/**
 * @author Chang
 * @description
 * @create 2021-07-14 10:41
 */
public enum  Country {
    ONE(1,"齐国"),
    TWO(2,"楚国"),
    THREE(3,"燕国"),
    FOUR(4,"韩国"),
    FIVE(5,"赵国"),
    SIX(6,"魏国"),
    SEVEN(7,"秦国");

    public Integer getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

    private Integer code;
    private String msg;

    Country(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    // 根据code辨别国名
    public static Country findCountry(Integer code){

        Country[] countries = Country.values();
        for(Country country:countries){

            if (code.equals(country.getCode())) {
                return country;
            }
        }

        return null;
    }
}
