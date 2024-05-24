package Model;

import lombok.*;

import java.util.Date;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Expense {

    private int expense_id;
    private String expense_name;
    private String expense_description;
    private int expense_amount;

}
