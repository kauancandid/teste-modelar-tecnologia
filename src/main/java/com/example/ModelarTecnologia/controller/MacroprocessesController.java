package com.example.ModelarTecnologia.controller;

import com.example.ModelarTecnologia.dto.macroprocesses.MacroprocessesRequestDTO;
import com.example.ModelarTecnologia.dto.macroprocesses.MacroprocessesResponseDTO;
import com.example.ModelarTecnologia.model.MacroprocessesModel;
import com.example.ModelarTecnologia.service.impl.MacroprocessesServiceImpl;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping(value = "/macroprocesses", produces="application/json")
public class MacroprocessesController {

    private MacroprocessesServiceImpl macroprocessoService;

    @Autowired
    public MacroprocessesController(MacroprocessesServiceImpl macroprocessoService) {
        this.macroprocessoService = macroprocessoService;
    }

    @ApiOperation("This method is used to save macroprocesses.")
    @PostMapping()
    public ResponseEntity<MacroprocessesResponseDTO> saveMacroProcesso(@RequestBody @Valid MacroprocessesRequestDTO macroprocessesRequestDTO) {
        MacroprocessesModel macroprocessosSaved = this.macroprocessoService.saveMacrorocesso(macroprocessesRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(MacroprocessesResponseDTO.convertToDTO(macroprocessosSaved));
    }

    @ApiOperation("This method is used to update macroprocessesId data.")
    @PatchMapping("update/{macroprocessesId}")
    public ResponseEntity<MacroprocessesResponseDTO> updateMacroprocessesId(@PathVariable String macroprocessesId,
                                                                                     @RequestBody @Valid MacroprocessesRequestDTO macroprocessesRequestDTO) {

        var macroprocesses = this.macroprocessoService.updateMacroprocesses(macroprocessesId, macroprocessesRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(MacroprocessesResponseDTO.convertToDTO(macroprocesses));
    }

    @ApiOperation("This method is used to list all macroprocesses data.")
    @GetMapping("/get-all")
    public ResponseEntity<List<MacroprocessesResponseDTO>> listMacroprocesses() {

        List<MacroprocessesModel> macroprocessesModels = this.macroprocessoService.listAllMacroprocesses();
        List<MacroprocessesResponseDTO> macroprocessesResponseDTOS = new ArrayList<>();
        for (MacroprocessesModel macroprocessesModel : macroprocessesModels) {
            macroprocessesResponseDTOS.add(MacroprocessesResponseDTO.convertToDTO(macroprocessesModel));
        }

        return ResponseEntity.status(HttpStatus.OK).body(macroprocessesResponseDTOS);
    }

    @ApiOperation("This method is used to list macroprocessesId data.")
    @GetMapping("get/{macroprocessesId}")
    public ResponseEntity<MacroprocessesResponseDTO> listProcessesId(@PathVariable String macroprocessesId) {
        var macroprocessesModel = this.macroprocessoService.listMacroprocesses(macroprocessesId);

        return ResponseEntity.status(HttpStatus.OK).body(MacroprocessesResponseDTO.convertToDTO(macroprocessesModel));
    }

    @ApiOperation("This method is used to delete one macroprocesses registered.")
    @DeleteMapping("delete/{macroprocessesId}")
    public ResponseEntity deleteClassification(@PathVariable String macroprocessesId) {
        this.macroprocessoService.deleteMacroprocesses(macroprocessesId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
