package ru.otus.shell;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellOption;
import ru.otus.config.YamlProperties;
import ru.otus.dao.DaoFile;
import ru.otus.io.IOService;
import ru.otus.view.ConsoleViewService;

@ShellComponent
public class AppCommands {

    private final ConsoleViewService consoleViewService;
    private final YamlProperties yamlProperties;
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    public AppCommands(ConsoleViewService consoleViewService, YamlProperties yamlProperties) {
        this.consoleViewService = consoleViewService;
        this.yamlProperties = yamlProperties;
    }

    @ShellMethod("Launch main application menu")
    public void start(){
        consoleViewService.startInteraction();
    }

    @ShellMethod("Change locale")
    public String changeLocale(@ShellOption String locale){

        DaoFile questionDaoFile = (DaoFile) applicationContext.getBean("questionDaoFileImpl");
        DaoFile answerDaoFilel = (DaoFile) applicationContext.getBean("answerDaoFileImpl");
        IOService ioService = (IOService) applicationContext.getBean("IOServiceImpl");

        questionDaoFile.setFileName(yamlProperties.getQaPath()+locale+yamlProperties.getFileExt());
        answerDaoFilel.setFileName(yamlProperties.getQaPath()+locale+yamlProperties.getFileExt());
        ioService.setLanguage(locale);

        return "Locale changed to "+locale;
    }

}
