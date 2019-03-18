package ru.otus.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellOption;
import ru.otus.config.YamlProperties;
import ru.otus.dao.DaoFile;
import ru.otus.domain.User;
import ru.otus.domain.UserAnswer;
import ru.otus.io.IOService;
import ru.otus.service.GetUserAnswerService;
import ru.otus.service.GetUserService;
import ru.otus.view.ConsoleViewService;

import java.util.List;

@ShellComponent
public class AppCommands {

    private final ConsoleViewService consoleViewService;
    private final YamlProperties yamlProperties;
    private final DaoFile questionDaoFile;
    private final DaoFile answerDaoFile;
    private final IOService ioService;
    private final GetUserService getUserService;;

    @Autowired
    public AppCommands(ConsoleViewService consoleViewService, YamlProperties yamlProperties
            , @Qualifier("questionDaoFileImpl") DaoFile questionDaoFile
            , @Qualifier("answerDaoFileImpl") DaoFile answerDaoFile, IOService ioService, GetUserAnswerService getUserAnswerService, GetUserService getUserService) {
        this.consoleViewService = consoleViewService;
        this.yamlProperties = yamlProperties;
        this.questionDaoFile = questionDaoFile;
        this.answerDaoFile = answerDaoFile;
        this.ioService = ioService;
        this.getUserService = getUserService;
    }

    @ShellMethod("Launch main application menu")
    public void start(){
        consoleViewService.startInteraction();
    }

    @ShellMethod("Change locale ")
    public String changeLocale(@ShellOption String locale){
        questionDaoFile.setFileName(yamlProperties.getQaPath()+locale+yamlProperties.getFileExt());
        answerDaoFile.setFileName(yamlProperties.getQaPath()+locale+yamlProperties.getFileExt());
        ioService.setLanguage(locale);
        return "Locale changed to "+locale;
    }

    private User user;
    private List<UserAnswer> userAnswers;

    @ShellMethod("Login to test service.")
    public void login() {
        user = getUserService.getUser();
        userAnswers=null;
    }

    @ShellMethod("Start test.")
    public void getTested() {
        userAnswers = consoleViewService.getTested(user);
    }

    @ShellMethod("Show results of examination.")
    public void showResults() {
        ioService.showResults(userAnswers);

    }

    public Availability getTestedAvailability() {
        return (user!=null)
                ? Availability.available()
                : Availability.unavailable("you are not logged in");
    }

    public Availability showResultsAvailability() {
        return (userAnswers!=null)
                ? Availability.available()
                : Availability.unavailable("you have not started the test");
    }
}
