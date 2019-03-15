package ru.otus.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.domain.Answer;
import ru.otus.domain.Question;
import ru.otus.domain.User;
import ru.otus.domain.UserAnswer;
import ru.otus.service.GetUserAnswerService;
import ru.otus.io.IOService;
import ru.otus.service.GetUserService;
import ru.otus.service.QACorrespondenceService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsoleViewServiceImpl implements ConsoleViewService<UserAnswer> {
    final QACorrespondenceService qaCorrespondenceService;
    final GetUserService getUserService;
    final GetUserAnswerService getUserAnswerService;
    final IOService ioService;

    @Autowired
    public ConsoleViewServiceImpl(QACorrespondenceService qaCorrespondenceService
                                , GetUserService getUserService
                                , GetUserAnswerService getUserAnswerService
                                , IOService ioService) {
        this.qaCorrespondenceService = qaCorrespondenceService;
        this.getUserService = getUserService;
        this.getUserAnswerService = getUserAnswerService;
        this.ioService = ioService;
    }

    @Override
    public List<UserAnswer> getTested() {
        User user = getUserService.getUser();
        List<UserAnswer> userAnswers =new ArrayList<>();
        List<Question>  questionList =  qaCorrespondenceService.correspondQA();
        if (questionList.size()>0) {
            for (int k = 0; k < questionList.size(); k++) {
                Question question = questionList.get(k);
                ioService.showText(k + 1 + ". " + question.getText());
                ioService.showText("\n");
                for (int i = 0; i < question.getAnswerList().size(); i++) {
                    ioService.showText(i + 1 + "." + question.getAnswerList().get(i).getText() + " ");
                }
                ioService.showText("\n");
                int choice = Integer.parseInt(ioService.userInput(ioService.printLocaleMes("test.enterNumber")+": ")) - 1;
                Answer answer = question.getAnswerList().get(choice);
                userAnswers.add(getUserAnswerService.getUserAnswer(user, question, answer));
            }
        }
        return userAnswers;
    }

    @Override
    public void startInteraction() {
        outlabel:
        while (true){
            ioService.showMenu();
            String menuOption = ioService.userInput(ioService.printLocaleMes("test.chooseOptionPrompt")+": ");
            switch (menuOption) {
                case "1":
                    ioService.showResults(getTested());
                    break;
                case "q":
                    break outlabel;
            }
        }
    }
}
