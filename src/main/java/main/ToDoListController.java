package main;

import main.model.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import main.model.Case;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ToDoListController {

    @Autowired
    private CaseRepository caseRepository;

    @GetMapping("/cases/")
    public List<Case> getList() {
        List<Case> cases = new ArrayList<Case>();
        caseRepository.findAll().forEach(cases::add);
        cases.forEach(System.out::println);
        return cases;
    }

    @PostMapping("/cases/")
    public int addToList(Case newCase) {
        Case newCase2 = caseRepository.save(newCase);
        return newCase2.getId();
    }

//    @DeleteMapping("/cases/")
//    public ResponseEntity deleteList() {
//        Storage.deleteCases();
//        return new ResponseEntity(HttpStatus.OK);
//    }

//    @PutMapping("/cases/")
//    public ResponseEntity putList(Case newCases) {
//        String[] values = newCases.getValue().split(",");
//        String[] deadLines = newCases.getDeadLine().split(",");
//        List<Case> cases = new ArrayList<Case>();
//        for (int i = 0; i < values.length; i++) {
//            cases.add(new Case(values[i], deadLines[i]));
//        }
//        Storage.putCases(cases);
////        System.out.println(newCases.get(0).getValue() + " " + newCases.get(0).getDeadLine());
//        return ResponseEntity.status(HttpStatus.OK).body(null);
//    }

//    @GetMapping("/cases/{id}")
//    public ResponseEntity getCase(@PathVariable int id) {
//        Case newCase = Storage.getCase(id);
//        if (newCase == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//        return new ResponseEntity(newCase, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/cases/{id}")
//    public ResponseEntity deleteCase(@PathVariable int id) {
//        boolean flag = Storage.deleteCase(id);
//        if (flag) {
//            return ResponseEntity.status(HttpStatus.OK).body(null);
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//    }
//
//    //Метод запрещён
//    @PostMapping("/cases/{id}/")
//    public ResponseEntity addCase(@PathVariable int id) {
//        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
//    }
//
//    //Обновление данных
//    @PutMapping("/cases/{id}")
//    public ResponseEntity putCase(Case newCase, @PathVariable int id) {
//        boolean flag = Storage.putCase(id, newCase);
//        if (flag) {
//            return ResponseEntity.status(HttpStatus.OK).body(null);
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//    }
}
