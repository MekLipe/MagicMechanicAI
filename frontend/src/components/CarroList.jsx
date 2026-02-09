import { useEffect, useState } from "react";
import { api } from "../services/api";
import "./CarroList.css";

export default function CarroList({ onSelect }) {
  const [carros, setCarros] = useState([]);

  async function carregar() {
    const res = await api.get("/carro/Listar");
    setCarros(res.data);
  }

  useEffect(() => {
    carregar();
  }, []);

  return (
    <div>
      <h2>Carros Cadastrados</h2>

      {carros.map(c => (
        <div className="carro-item" key={c.id}>
          <span>
            {c.marca} {c.modelo} - {c.motorizacao}
          </span>

          <button onClick={() => onSelect(c)}>
            Selecionar
          </button>
        </div>
      ))}
    </div>
  );
}
