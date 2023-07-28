package br.com.fiap.empregados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.empregados.model.Empregado;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Long>{

}
