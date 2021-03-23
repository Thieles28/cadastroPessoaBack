package app.com.cadastro.repository;

import app.com.cadastro.model.Naturalidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaturalidadeRepository extends JpaRepository<Naturalidade, Long> {
}
