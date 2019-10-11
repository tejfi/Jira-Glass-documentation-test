pipeline{
    agent any
    stages {
        stage('SCM checkout'){
            steps{
                git 'https://github.com/tejfi/jira-project.git'
            }
        }
        stage('compile-package'){
            sh 'mvn package'
              }

        stage ('Test Stage') {
            steps {
                withMaven(maven: 'maven_4_0__0') {
                    sh 'mvn test'
                }
            }
        }

        stage ('Cucumber Reports') {

            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: 'target'

            }

        }

    }

}
