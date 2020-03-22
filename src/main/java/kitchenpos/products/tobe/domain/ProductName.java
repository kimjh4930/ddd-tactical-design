package kitchenpos.products.tobe.domain;

import kitchenpos.products.tobe.exception.WrongProductNameException;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;

@Embeddable
public class ProductName {

    private String name;

    protected ProductName(){}

    public ProductName(String name){
        this.name = validateProductName(name.replaceAll("\\p{Z}", ""));
    }

    public String valueOf(){
        return this.name;
    }

    public String validateProductName (String name){
        if(StringUtils.isBlank(name)){
            throw new WrongProductNameException("제품명을 한글자 이상 넣어주세요.");
        }
        return name;
    }

}
