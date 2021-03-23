package app.com.cadastro.repository;

import app.com.cadastro.model.Nacionalidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NacionalidadeRepository extends JpaRepository<Nacionalidade, Long> {
}
