package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
//@ScriptAssert를 억지로 사용하기보단 자바코드로 직접 체크하는 것을 권장
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000", message = "총 합이 10,000이 넘게 등록해주세요.")
public class Item {

    private Long id;

//    @NotBlank(groups = UpdateCheck.class)
    private String itemName;

//    @NotNull @Range(min = 1000, max = 1000000, groups = {SaveCheck.class,UpdateCheck.class})
    private Integer price;

//    @NotNull(groups = {SaveCheck.class,UpdateCheck.class})
//    @Max(value = 9999,groups = SaveCheck.class)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
