package com.example.tugas1.controller;

import com.example.tugas1.entity.Mahasiswa;
import com.example.tugas1.repository.MahasiswaRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MahasiswaController {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @GetMapping("/")
    public String listMahasiswa(Model model, @RequestParam(required = false) String query) {
        List<Mahasiswa> mahasiswas;
        if (query == null) {
            mahasiswas = mahasiswaRepository.findAll();
        } else {
            mahasiswas = mahasiswaRepository.findByNimContainingOrNamaContaining(query, query);
        }
        model.addAttribute("mahasiswas", mahasiswas);
        return "list_mahasiswa";
    }

    @GetMapping("/add")
    public String addMahasiswaForm(Mahasiswa mahasiswa) {
        return "add_mahasiswa";
    }

    @PostMapping("/add")
    public String addMahasiswa(@Valid Mahasiswa mahasiswa, BindingResult result) {
        if (result.hasErrors()) {
            return "add_mahasiswa";
        }
        mahasiswaRepository.save(mahasiswa);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editMahasiswaForm(@PathVariable("id") Long id, Model model) {
        Mahasiswa mahasiswa = mahasiswaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Mahasiswa Id: " + id));
        model.addAttribute("mahasiswa", mahasiswa);
        return "edit_mahasiswa";
    }

    @GetMapping("/detail/{id}")
    public String detailMahasiswaForm(@PathVariable("id") Long id, Model model) {
        Mahasiswa mahasiswa = mahasiswaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Mahasiswa Id: " + id));
        model.addAttribute("mahasiswa", mahasiswa);
        return "detail_mahasiswa";
    }

    @PostMapping("/edit/{id}")
    public String editMahasiswa(@PathVariable("id") Long id, @Valid @RequestBody Mahasiswa mahasiswa, BindingResult result) {
        if (result.hasErrors()) {
            mahasiswa.setId(id);
            return "edit_mahasiswa";
        }
        mahasiswaRepository.save(mahasiswa);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteMahasiswa(@PathVariable("id") Long id) {
        Mahasiswa mahasiswa = mahasiswaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Mahasiswa Id: " + id));
        mahasiswaRepository.delete(mahasiswa);
        return "redirect:/";
    }
}
