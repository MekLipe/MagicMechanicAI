import { useState } from "react";
import { api } from "../services/api";
import "./CarroForm.css";

export default function CarroForm({ onCarroCadastrado }) {
  const [carro, setCarro] = useState({
    marca: "",
    modelo: "",
    ano: "",
    versao: "",
    motorizacao: ""
  });

  function handleChange(e) {
    setCarro({ ...carro, [e.target.name]: e.target.value });
  }

  async function handleSubmit(e) {
    e.preventDefault();
      const carroParaEnviar = {
        ...carro,
        ano: Number(carro.ano)
      };
    await api.post("/carro/Criar", carroParaEnviar);
    setCarro({ marca: "", modelo: "", ano: "", versao: "", motorizacao: "" });
    onCarroCadastrado();
  }

  return (
    <form onSubmit={handleSubmit} className="carro-form">
      <h2>Cadastrar Carro</h2>

      <div className="form-grid">
        <input name="marca" placeholder="Marca" value={carro.marca} onChange={handleChange} />
        <input name="modelo" placeholder="Modelo" value={carro.modelo} onChange={handleChange} />
        <input name="ano" placeholder="Ano" value={carro.ano} onChange={handleChange} />
        <input name="versao" placeholder="Versão" value={carro.versao} onChange={handleChange} />
        <input name="motorizacao" placeholder="Motorização" value={carro.motorizacao} onChange={handleChange} />
      </div>

      <div className="form-actions">
        <button type="submit">Cadastrar</button>
      </div>
    </form>
  );
}