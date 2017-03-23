import jenkins.model.*

def jobName = "HelloWorld"
def scm = '''<scm class="hudson.scm.NullSCM"/>'''

def configXml = """\
<?xml version='1.0' encoding='UTF-8'?>
<project>
  <description></description>
  <keepDependencies>false</keepDependencies>
  <properties/>
  <scm class="hudson.scm.NullSCM"/>
  <canRoam>true</canRoam>
  <disabled>false</disabled>
  <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>
  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>
  <triggers/>
  <concurrentBuild>false</concurrentBuild>
  <builders>
    <hudson.tasks.Shell>
      <command>echo Hello World</command>
    </hudson.tasks.Shell>
  </builders>
  <publishers/>
  <buildWrappers/>
</project>
""".stripIndent()


def xmlStream = new ByteArrayInputStream( configXml.getBytes() )
try {
  def helloworldJob = Jenkins.instance.createProjectFromXML(jobName, xmlStream)
  helloworldJob.scheduleBuild(0, null)
} catch (ex) {
  println "ERROR: ${ex}"
  println configXml.stripIndent()
}

