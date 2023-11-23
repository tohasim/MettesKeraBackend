package dat3.rename_me.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Category {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;


}
