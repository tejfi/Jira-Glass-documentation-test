node{
  environment {
        env.SEHUB_USERNAME = credentials('SEHUB_USERNAME')
        env.SEHUB_PW = credentials('SEHUB_PW')
        env.JIRA_USERNAME = credentials('JIRA_USERNAME')
        env.JIRA_PASSWORD = credentials('JIRA_PASSWORD')
        env.SEHUB_URL = credentials('SEHUB_URL')
        env.JAVA_HOME = /usr/bin/java
        }
  stage('SCM checkout'){
    git 'https://github.com/tejfi/Jira-Glass-documentation-test.git'
  }
  stage('compile-package'){
    sh 'mvn package'
  }
}
