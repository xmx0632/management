package org.xmx0632.management.entity;


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.xmx0632.management.entity.IdEntity;

/**
 * FruitSubPromotion.
 */
@Entity
@Table(name="tbl_fruit_sub_promotion"
)
public class FruitSubPromotion extends IdEntity {


    private Long productId;
    private String productName;
    private Long promotionProductId;
    private String promotionProductName;
    private BigDecimal promotionPrice;
    private BigDecimal promotionThreshold;
    private String unit;
    private Byte subType;
    private String spec;
    private Date startTime;
    private Date endTime;

    public FruitSubPromotion() {
    }

   

    public Long getProductId() {
        return this.productId;
    }
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getPromotionProductId() {
        return this.promotionProductId;
    }
    
    public void setPromotionProductId(Long promotionProductId) {
        this.promotionProductId = promotionProductId;
    }

    public String getPromotionProductName() {
        return this.promotionProductName;
    }
    
    public void setPromotionProductName(String promotionProductName) {
        this.promotionProductName = promotionProductName;
    }

    public BigDecimal getPromotionPrice() {
        return this.promotionPrice;
    }
    
    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public BigDecimal getPromotionThreshold() {
        return this.promotionThreshold;
    }
    
    public void setPromotionThreshold(BigDecimal promotionThreshold) {
        this.promotionThreshold = promotionThreshold;
    }

    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Byte getSubType() {
        return this.subType;
    }
    
    public void setSubType(Byte subType) {
        this.subType = subType;
    }

    public String getSpec() {
        return this.spec;
    }
    
    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}


