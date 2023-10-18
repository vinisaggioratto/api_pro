package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.repository.SaidaEstoqueRepository;
import com.vinicius.condominiopro.saidaEstoque.SaidaEstoque;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/saidasestoque")
public class SaidaEstoqueController {
	
	@Autowired
	private SaidaEstoqueRepository repository;

}
