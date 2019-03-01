package ru.otus.view;

import ru.otus.domain.Answer;
import ru.otus.domain.Question;
import ru.otus.domain.User;
import ru.otus.domain.UserAnswer;
import ru.otus.service.GetUserService;
import ru.otus.service.IOService;
import ru.otus.service.QACorrespondenceService;

import java.util.ArrayList;
import java.util.List;

public class ConsoleViewServiceImpl implements ConsoleViewService<UserAnswer> {
    final QACorrespondenceService qaCorrespondenceService;
    final GetUserService getUserService;
    final IOService ioService;

    public ConsoleViewServiceImpl(QACorrespondenceService qaCorrespondenceService, GetUserService getUserService, IOService ioService) {
        this.qaCorrespondenceService = qaCorrespondenceService;
        this.getUserService = getUserService;
        this.ioService = ioService;
    }

    @Override
    public List<UserAnswer> getTested() {
        User user = getUserService.getUser();
        List<UserAnswer> userAnswers = new ArrayList<>();
        List<Question>  questionList =  qaCorrespondenceService.correspondQA();
        for (int k=0;k<questionList.size();k++ ){
            Question question = questionList.get(k);
            ioService.showText(k+1+". "+question.getText());
            ioService.showText("\n");
            for(int i=0; i<question.getAnswerList().size();i++){
                ioService.showText(i+1 +"." +question.getAnswerList().get(i).getText() + " ");
            }
            ioService.showText("\n");
            int choice = Integer.parseInt(ioService.userInput("Введите номер ответа: "))-1;
            Answer answer = question.getAnswerList().get(choice);
            userAnswers.add(new UserAnswer(user, question, answer));
        }
        return userAnswers;
    }

    @Override
    public void startInteraction() {
        while (true){
            ioService.showMenu();
            String menuOption = ioService.userInput("Выберете нужный пункт меню или введите 'q' для выхода из программы: ");
            switch (menuOption) {
                case "1":
                    ioService.showResults(getTested());
                    break;
                case "q":
                    System.exit(0);
                    break;
            }
        }
    }
}
