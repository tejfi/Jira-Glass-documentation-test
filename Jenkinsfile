node{
  env.JAVA_HOME = credentials('JAVA_HOME')
  environment {
        SEHUB_USERNAME = credentials('SEHUB_USERNAME')
        SEHUB_PW = credentials('SEHUB_PW')
        JIRA_USERNAME = credentials('JIRA_USERNAME')
        JIRA_PASSWORD = credentials('JIRA_PASSWORD')
        SEHUB_URL = credentials('SEHUB_URL')
    }
  stage('SCM checkout'){
    git 'https://github.com/tejfi/Jira-Glass-documentation-test.git'
  }
  stage('compile-package'){
    sh 'mvn package'
  }
}
