
node{
  stage('SCM checkout'){
    git 'https://github.com/tejfi/jira-project.git'
  }
  stage('compile-package){
  sh 'mvn package'
  }