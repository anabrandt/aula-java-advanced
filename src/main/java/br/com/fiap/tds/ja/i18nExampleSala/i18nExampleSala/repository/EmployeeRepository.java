package br.com.fiap.tds.ja.i18nExampleSala.i18nExampleSala.repository;

import br.com.fiap.tds.ja.i18nExampleSala.i18nExampleSala.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
