package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.contrader.converter.ConverterOpenjob;
import it.contrader.dao.OpenjobRepository;
import it.contrader.dto.OpenjobDTO;
import it.contrader.model.Openjob;

@Service
public class OpenjobService {

	private final OpenjobRepository openjobRepository;

	@Autowired
	public OpenjobService(OpenjobRepository openjobRepository) {
		this.openjobRepository = openjobRepository;
	}

	public List<OpenjobDTO> getListaOpenjobDTO() {
		return ConverterOpenjob.toListDTO((List<Openjob>) openjobRepository.findAll());
	}

	public OpenjobDTO getOpenjobDTOById(Integer id) {
		return ConverterOpenjob.toDTO(openjobRepository.findById(id).get());
	}

	public OpenjobDTO getByTitolo(String titolo) {

		final Openjob openjob = openjobRepository.findOpenjobByTitolo(titolo);

		return ConverterOpenjob.toDTO(openjob);
	}

	public boolean insertOpenjob(OpenjobDTO openjobDTO) {
		return openjobRepository.save(ConverterOpenjob.toEntity(openjobDTO)) != null;
	}

	public boolean updateOpenjob(OpenjobDTO openjobDTO) {
		return openjobRepository.save(ConverterOpenjob.toEntity(openjobDTO)) != null;
	}
	
	public void deleteOpenjobById(Integer id) {
		openjobRepository.deleteById(id);
	}
	
	public List<OpenjobDTO> findOpenjobDTOById(Integer id) {
		
		final List<Openjob> list = openjobRepository.findAllById(id);
		final List<OpenjobDTO> openjobDTOs = new ArrayList<>();
		list.forEach(i -> openjobDTOs.add(ConverterOpenjob.toDTO(i)));
		return openjobDTOs;
		
	
	}

	public OpenjobDTO readOpenjobById(int id) {
		// TODO Auto-generated method stub
		return ConverterOpenjob.toDTO(openjobRepository.readById(id));
		
	}

	public List<OpenjobDTO> getMyJobs(int idCompany) {
		return ConverterOpenjob.toListDTO(openjobRepository.findAllByIdCompany(idCompany));
		// TODO Auto-generated method stub
		
	}
}
