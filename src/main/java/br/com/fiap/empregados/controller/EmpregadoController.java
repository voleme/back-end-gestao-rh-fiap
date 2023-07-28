package br.com.fiap.empregados.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.empregados.model.Empregado;
import br.com.fiap.empregados.service.EmpregadoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/fiap/api/v1")
public class EmpregadoController {
	
	@Autowired
	private EmpregadoService service;
	
	@PostMapping("/empregados")
	public Empregado createEmpregado(@RequestBody Empregado empregado) {
		return service.createEmpregado(empregado);
	}

	@GetMapping("/empregados")
	public List<Empregado> getAllEmpregados(){
		return service.getAllEmpregados();
	}
	
	@GetMapping("/empregados/{id}")
	public ResponseEntity<Empregado> getEmpregadoById(@PathVariable Long id) {

		Empregado empregado = service.getEmpregadoById(id);

		return ResponseEntity.ok(empregado);
	}
	
	@PutMapping("/empregados/{id}")
	public ResponseEntity<Empregado> updateEmpregado(@PathVariable Long id, @RequestBody Empregado empregado){

		Empregado updatedEmpregado = service.updateEmpregado(id, empregado);
		
		return ResponseEntity.ok(updatedEmpregado);
	}
	
	@DeleteMapping("/empregados/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmpregado(@PathVariable Long id){
	
		service.deleteEmpregado(id);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
	
}