package app.com.cadastro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tb_estado")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Naturalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    @Column(name = "nome")
    private String nome;
}
