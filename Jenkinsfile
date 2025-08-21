pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'cadastro-cliente'
        DOCKER_TAG = 'latest'
        DOCKER_HOST = 'tcp://docker-dind:2375'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/lleolopes03/cadastro-cliente.git'
            }
        }

        stage('Build com Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
            }
        }

        stage('Deploy com Docker Compose') {
            steps {
                timeout(time: 2, unit: 'MINUTES') {
                    sh 'docker-compose up -d --no-deps --build cadastro-cliente'
                }
            }
        }

        stage('Verificação') {
            steps {
                script {
                    def tentativas = 5
                    def sucesso = false

                    for (int i = 0; i < tentativas; i++) {
                        def status = sh(script: "curl -s http://cadastro-cliente:8080/actuator/health | grep UP", returnStatus: true)
                        if (status == 0) {
                            echo "✅ Serviço está saudável!"
                            sucesso = true
                            break
                        }
                        echo "⏳ Tentativa ${i + 1} falhou, aguardando 5s..."
                        sleep 5
                    }

                    if (!sucesso) {
                        error("❌ Serviço cadastro-cliente não respondeu como esperado.")
                    }
                }
            }
        }
    }

    post {
        success {
            echo '✅ Deploy do cadastro-cliente concluído com sucesso!'
        }
        failure {
            echo '❌ Falha no pipeline. Verifique os logs.'
        }
    }
}