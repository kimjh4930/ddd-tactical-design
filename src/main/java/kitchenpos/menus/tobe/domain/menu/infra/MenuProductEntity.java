package kitchenpos.menus.tobe.domain.menu.infra;

import kitchenpos.common.PositiveNumber;
import kitchenpos.common.Price;
import kitchenpos.menus.tobe.domain.menu.vo.MenuProductVO;
import kitchenpos.menus.tobe.domain.menu.vo.MenuProducts;

import javax.persistence.*;

@Entity
@Table(name = "menu_product")
public class MenuProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private MenuEntity menu;

    @Embedded
    @AttributeOverride(
        name = "number",
        column = @Column(name = "product_id")
    )
    private PositiveNumber productId;

    @Embedded
    @AttributeOverride(
        name = "number",
        column = @Column(name = "quantity")
    )
    private PositiveNumber quantity;

    protected MenuProductEntity(){}

    public MenuProductEntity (MenuProductVO menuProductVO){
        this.productId = new PositiveNumber(menuProductVO.getProductId());
        this.quantity = new PositiveNumber(menuProductVO.getQuantity());
    }

    public Long getId (){
        return id;
    }

    public Long getProductId() {
        return productId.valueOf();
    }

    public Long getQuantity() {
        return quantity.valueOf();
    }
}
