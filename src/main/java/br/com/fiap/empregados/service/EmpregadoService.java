package br.com.fiap.empregados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.empregados.exception.ResourceNotFoundException;
import br.com.fiap.empregados.model.Empregado;
import br.com.fiap.empregados.repository.EmpregadoRepository;

@Service
public class EmpregadoService {

	@Autowired
	private EmpregadoRepository repository;

	public Empregado createEmpregado(Empregado empregado) {
		return repository.save(empregado);
	}

	public List<Empregado> getAllEmpregados() {
		return repository.findAll();
	}
	
	public Empregado getEmpregadoById(Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Empregado não existe com id:" + id));
	}

	public Empregado updateEmpregado(Long id, Empregado empregadoDetails) {

		Empregado empregado = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Empregado não existe com id:" + id));

		empregado.setNome(empregadoDetails.getNome());
		empregado.setCargo(empregadoDetails.getCargo());
		empregado.setEmail(empregadoDetails.getEmail());

		return repository.save(empregado);
	}

	public void deleteEmpregado(Long id) {

		Empregado empregado = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Empregado não existe com id:" + id));

		repository.delete(empregado);
	}

}
