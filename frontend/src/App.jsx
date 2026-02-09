import { useState } from "react";
import CarroForm from "./components/CarroForm";
import CarroList from "./components/CarroList";
import IARecommendation from "./components/IARecommendation";

function App() {
  const [carroSelecionado, setCarroSelecionado] = useState(null);

  return (
    <div className="container">
      <h1>Magic Mechanic AI 🧙‍♂️🔧</h1>

      <div className="card">
        <CarroForm onCarroCadastrado={() => window.location.reload()} />
      </div>

      <div className="card">
        <CarroList onSelect={setCarroSelecionado} />
      </div>

      <div className="card">
        <IARecommendation carro={carroSelecionado} />
      </div>
    </div>
  );
}

export default App;
