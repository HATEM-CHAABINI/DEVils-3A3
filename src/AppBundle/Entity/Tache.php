<?php

namespace AppBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Tache
 *
 * @ORM\Table(name="tache")
 * @ORM\Entity
 */
class Tache
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_tache", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idTache;

    /**
     * @var integer
     *
     * @ORM\Column(name="id_employé", type="integer", nullable=false)
     */
    private $idEmploy�;

    /**
     * @var integer
     *
     * @ORM\Column(name="id_rec", type="integer", nullable=false)
     */
    private $idRec;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=20, nullable=false)
     */
    private $description;



    /**
     * Get idTache
     *
     * @return integer
     */
    public function getIdTache()
    {
        return $this->idTache;
    }

    /**
     * Set idEmploy�
     *
     * @param integer $idEmploy�
     *
     * @return Tache
     */
    public function setIdEmploy�($idEmploy�)
    {
        $this->idEmploy� = $idEmploy�;

        return $this;
    }

    /**
     * Get idEmploy�
     *
     * @return integer
     */
    public function getIdEmploy�()
    {
        return $this->idEmploy�;
    }

    /**
     * Set idRec
     *
     * @param integer $idRec
     *
     * @return Tache
     */
    public function setIdRec($idRec)
    {
        $this->idRec = $idRec;

        return $this;
    }

    /**
     * Get idRec
     *
     * @return integer
     */
    public function getIdRec()
    {
        return $this->idRec;
    }

    /**
     * Set description
     *
     * @param string $description
     *
     * @return Tache
     */
    public function setDescription($description)
    {
        $this->description = $description;

        return $this;
    }

    /**
     * Get description
     *
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }
}
