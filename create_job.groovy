import jenkins.model.Jenkins;
import hudson.model.FreeStyleProject;

def helloworldJob = Jenkins.instance.createProject(FreeStyleProject, 'HelloWorld')
helloworldJob.buildersList.add(new hudson.tasks.Shell('echo Hello World'))
helloworldJob.scheduleBuild(0, null)

