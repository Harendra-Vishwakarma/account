pipeline{
    agent any
    tools{
        maven "MAVEN_HOME"
    }
    stages{
        stage("Test"){
            steps{
                sh "mvn test"
            }
            post{
                success{
                    echo "========Tested successfully========"
                }
                failure{
                    echo "========Test failed========"
                }
            }
        }
        stage("Build"){
            steps{
                sh "mvn clean package"
            }
            post{
                success{
                    echo "========Build successfully========"
                }
                failure{
                    echo "========Build failed========"
                }
            }
        }

        stage("Build deploy on AWS comcat"){
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat_deployer', path: '',
                 url: 'http://52.55.210.248:8090/')], 
                 contextPath: 'springApp', 
                 war: '**/*.war'
            }
            post{
                success{
                    echo "========Build successfully========"
                }
                failure{
                    echo "========Build failed========"
                }
            }
        }
    }
    post{
        always{
            echo "========always========"
        }
        success{
            echo "========pipeline executed successfully ========"
        }
        failure{
            echo "========pipeline execution failed========"
        }
    }
}
