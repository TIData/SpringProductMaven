
package domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author sebastiaan
 */
public class Price {
    @NotNull
    @Min(value = 1,message = "{price.percentIncrease.Min.message}")
    @Max(50)
    private Integer percentIncrease;
    @NotNull
    @Range(min = 1, max = 25, message = "{price.percentDecrease.Range.message}")
    private Integer percentDecrease;
    
    
    public Integer getPercentIncrease() {
        return percentIncrease;
    }

    public void setPercentIncrease(Integer percentIncrease) {
        this.percentIncrease = percentIncrease;
    }
    
    
    public Integer getPercentDecrease() {
        return percentDecrease;
    }

    public void setPercentDecrease(Integer percentDecrease) {
        this.percentDecrease = percentDecrease;
    }
    
}
