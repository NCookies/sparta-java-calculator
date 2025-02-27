package data;

import java.math.BigDecimal;

public record CalcParam (
        BigDecimal numX,
        BigDecimal numY,
        OperatorType operatorType
) {
}
