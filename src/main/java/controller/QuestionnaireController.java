package controller;

import com.example.demo.entity.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.QuestionnaireRepository;

import java.util.List;

@RestController
@RequestMapping("/api/questionnaires")
public class QuestionnaireController {

    private final QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireController(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    // Получение всех анкет
    @GetMapping
    public ResponseEntity<List<Questionnaire>> getAllQuestionnaires() {
        List<Questionnaire> questionnaires = questionnaireRepository.findAll();
        return new ResponseEntity<>(questionnaires, HttpStatus.OK);
    }

    // Получение анкеты по ID
    @GetMapping("/{id}")
    public ResponseEntity<Questionnaire> getQuestionnaireById(@PathVariable Long id) {
        Questionnaire questionnaire = questionnaireRepository.findById(id)
                .orElse(null);
        if (questionnaire != null) {
            return new ResponseEntity<>(questionnaire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Создание новой анкеты
    @PostMapping
    public ResponseEntity<Questionnaire> createQuestionnaire(@RequestBody Questionnaire questionnaire) {
        Questionnaire savedQuestionnaire = questionnaireRepository.save(questionnaire);
        return new ResponseEntity<>(savedQuestionnaire, HttpStatus.CREATED);
    }

    // Обновление анкеты
    @PutMapping("/{id}")
    public ResponseEntity<Questionnaire> updateQuestionnaire(@PathVariable Long id, @RequestBody Questionnaire updatedQuestionnaire) {
        Questionnaire existingQuestionnaire = questionnaireRepository.findById(id)
                .orElse(null);
        if (existingQuestionnaire != null) {
            updatedQuestionnaire.setId(id); // Устанавливаем ID обновляемой анкеты
            Questionnaire savedQuestionnaire = questionnaireRepository.save(updatedQuestionnaire);
            return new ResponseEntity<>(savedQuestionnaire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Удаление анкеты
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionnaire(@PathVariable Long id) {
        Questionnaire existingQuestionnaire = questionnaireRepository.findById(id)
                .orElse(null);
        if (existingQuestionnaire != null) {
            questionnaireRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}