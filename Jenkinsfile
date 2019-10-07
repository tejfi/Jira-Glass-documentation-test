node{
   environment {
     SEHUB_USERNAME='selenium'
     SEHUB_PW='CoolCanvas19.'
     SEHUB_URL='seleniumhub.codecool.codecanvas.hu/wd/hub'
     JIRA_USERNAME='user17'
     JIRA_PASSWORD='CoolCanvas19.'
     JAVA_HOME = /usr/bin/java
   }
  stage('SCM checkout'){
    git 'https://github.com/tejfi/Jira-Glass-documentation-test.git'
  }
  stage('compile-package'){
    sh 'mvn package'
  }
}
