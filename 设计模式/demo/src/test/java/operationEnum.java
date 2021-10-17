public enum operationEnum implements Cal{

    PLUS(){
        @Override
        public Double calculate(Double a, Double b) {
            return a+b;
        }
    };


}
